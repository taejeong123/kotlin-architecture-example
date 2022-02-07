# Kotlin Architecture


## 1. MVC (Model-View-Controller)

### 1.1. 구조와 동작
> MVC 패턴에서는 사용자 입력은 컨트롤러(Activity)를 통해 들어오며 컨트롤러는 모델과 상호작용을 통해 View(xml)를 업데이트 하며, View는 모델을 참조하게 되는 구조

![MVC](https://user-images.githubusercontent.com/49433240/152747154-2e0212c2-80eb-43d5-915d-63b1d2c81067.png)

### 1.2. 특징
- Controller(Activity)
    - 앱을 묶어주는 접착제 역할(Activity/Fragment)
    - 사용자에게 입력을 받아 해당하는 모델을 선택하여 처리한다.
    - 모델의 데이터 변화에 따라 뷰를 선택한다.
- View(XML)
    - 사용자에게 제공되는 UI
    - UI, 앱과의 상호작용에서 컨트롤러와의 통신
    - 사용자가 어떤 액션을 하든 무엇을 해야할 지 모름
- Model
    - 데이터 + 상태 + 비즈니스 로직
    - View나 Controller에 묶이지 않아 재사용 가능

### 1.3. 장단점
- 장점
    - Model과 View를 분리
    - 어디에도 종속되지 않아 재사용 가능
    - 구현하기 가장 쉬움
- 단점
    - Controller가 View에 결합 되며, View의 확장이 될 수 있음
    - View와 Model 사이의 업데이트를 위해 직/간접적으로 참조. 이로 인해 서로 간의 의존성을 완벽하게는 없앨 수 없음
    - 규모가 커질수록 컨트롤러에 많은 코드가 쌓여 비대화 문제 발생

## 2. MVP (Model-View-Presenter)

### 2.1. 구조와 동작
> - Model과 View는 MVC의 개념과 동일하다.
> - Model과 View를 분리 시키기 위해 사이에 Presenter라는 개념을 추가시킨다.
> - 사용자 입력은 이제 View를 통해 들어온다.
> - View는 이러한 이벤트를 Presenter로 전달하고 Presenter는 Model과의 상호작용을 통해 View에게 업데이트 할 내용을 전달한다.
> - 내용을 전달받은 View가 최종적으로 업데이트 되며, 이로 인해 Presenter와 View는 1:1 관계를 유지한다.

![MVP](https://user-images.githubusercontent.com/49433240/152747233-243d9079-4848-4bd6-8859-a152cb8a7d55.png)

### 2.2. 특징
- Presenter
    - Model과 View의 상호작용 관리
    - 컨트롤러와 본질적으로는 동일 하지만 View에 연결되지 않는 단순 Interface이다.
    - VIew에게 표시할 내용만 전달
- View
    - 사용자에게 제공되는 UI
    - Activity/Fragment가 View의 일부로 간주된다.
    - 사용자의 입력을 받고 이벤트를 Presenter로 전달한다.
- Model
    - MVC와 동일

### 2.3. 장단점
- 장점
    - Model과 View의 의존성이 존재하지 않는다.
    - Model은 Presenter의 요청만을 수행한다.
- 단점
    - 규모가 커짐에 따라 Presenter도 추가 비지니스 로직이 모여 비대화 된다.
    - MVC에 비해 필요한 클래스 수가 증가한다.
    - View와 Presenter의 1:1 관계로 인한 의존성 증가.

## 3. MVVM (Model-View-ViewModel)

### 3.1. 구조와 동작
> - Model과 View는 MVC의 개념과 동일하다.
> - MVP와 마찬가지로 View와 Model을 분리시키기 위해 ViewModel이라는 개념이 들어온다.
> - View는 사용자 입력에 따른 자신이 이용할 ViewModel을 선택해 바인딩하여 업데이트를 받는다.
> - ViewModel과 Model이 상호작용을 하여 Model이 변경되면 ViewModel을 이용하는 View가 자동으로 업데이트 된다.
> - 이로인해 View와 Model 사이의 의존성이 없고, MVP처럼 View와 ViewModel이 1:1 관계가 아닌 독립적이기 때문에 이 둘 사이의 의존 관계가 성립되지 않는다.

![MVVM](https://user-images.githubusercontent.com/49433240/152747230-601bb84a-854c-48c3-8c63-23b07e8c07fe.png)

### 3.2. 특징
- ViewModel
    - View를 나타내주기 위한 Model + View의 로직 담당
    - View와 독립적
    - UI 관련 데이터 보관 및 관리
    - Model이 변경되면 해당 ViewModel을 사용하는 View가 자동으로 업데이트
- View
    - 사용자에게 제공되는 UI
    - 사용자의 입력을 받고 이벤트를 자신이 사용할 ViewModel로 전달
- Model
    - MVC와 동일

### 3.3. 장단점
- 장점
    - View에 대한 의존성이 전혀 없으므로 유닛 테스트에 용이
    - 중복되는 코드를 모듈화 할 수 있음
- 단점
    - ViewModel의 설계가 어렵다.
    - View에대한 처리가 복잡할수록 ViewModel이 거대해진다.
    - 상대적으로 View는 아무 역할도 하지 않음
    - ViewModel이 또다른 형태의 액티비티 클래스 구현으로 변질될 우려가 있다.

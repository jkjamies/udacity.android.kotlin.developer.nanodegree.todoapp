# udacity.android.kotlin.developer.nanodegree.todoapp
ToDoApp Application from Udacity Android Kotlin Developer Nanodegree program.

Highlights:

Using and Running Tests via file on line bar, Run window, file menu, and Android File/package explorer\
\
Test (Local tests) vs AndroidTest (Instrumented tests) (Test is faster with lower fidelity = how real world the test is, AndroidTest has real or emulated devices and is slower with more fidelity)\
\
Alt+Enter on function can generate test, or right click->generate->test\
\
Use TDD (Test-Driven-Development) to find/confirm issue by writing test, then fix/enhance code\
\
Readable Tests\
Naming - subjectUnderTest_actionOrInput_resultState or functionClassFeature_actionOrInput_ExpectedResult\
Given/When/Then Structuring - Testing mnemonic for structuring tests in a Given X, When Y, Then Z format similar to Arrange, Act, Assert (AAA) - given list of tasks, when you call getActiveAndCompletedStats, there are x% active and y% completed tasks\
Assertion Framework - assertEquals(result.completedTasksPercent, 0f) vs assertThat(result.completedTasksPercent, `is`(0f)) -> Hamcrest [there is also one called Truth]\
\
Testing Strategy\
Unit Tests [70%] [ViewModel w/LiveData, Repository, DAO] - single method or class, run fast and often, usually local and low fidelity\
Integration Tests [20%] [Fragments -> ViewModels, Database] - several classes (work together) or a feature, can be local or instrumented (real device), slower but still fast and higher fidelity but still lower\
End to end Tests [10%] [Entire App] - large portions of the app, high fidelity, test app works as whole, simulate real usage, almost always instrumented\
Strategies - Test what is easy to test, write end to end tests, architecture for new features, refactor when you have tests\
\
ViewModel test (local because it shouldn't rely on OS or framework)\
\
AndroidX Testing - Collection of libraries for testing providing android components like activities and applications used for local and instrumented tests.\
Before - local tests use Robolectric, Instrumented tests use Android Support Lib Test.\
Android X Test will pick the right one behind the scenes for you for the local or instrumented test.\
Swapping AndroidJUnit4 runner* - the runner dependency/dependencies are tied to this.\
\
InstantTaskExecutorRule for LiveData testing - classes define some code that runs before and after each test runs. If you need to test LiveData and ensure test results are synchronous\
and in a repeatable order, use this rule, as it is done on the same thread.\
Use the LiveDataTestUtil.kt file to keep the testing of LiveData simple and boiler plate code to a minimum in test files.\
\
Unit tests are highly focused, so the repository has complicated dependencies\
Solution: make fake dependencies\
Test Doubles:\
Fake - A test double that has a "working" implementation of the class, but it's implemented in a way that makes it good for tests but unsuitable for production\
Mock - A test double that tracks which of its methods were called. It then passes or fails a test depending on whether it's methods were called correctly.\
Stub - A test double that includes no logic and only returns what you program it to return. A StubTaskRepository could be programmed to return certain combinations of tasks from getTasks for example.\
Dummy - A test double that is passed around but not used, such as if you just need to provide it as a parameter. If you had a DummyTaskRepository, it would just implement the TaskRepository with no code in any of the methods.\
Spy - A test double which also keeps tracks of some additional information; for example, if you made a SpyTaskRepository, it might keep track of the number of times the addTask method was called.\
Check here for more information: https://testing.googleblog.com/2013/07/testing-on-toilet-know-your-test-doubles.html \
\
Dependency Injection\
Constructor Injection\
Forced to choose dependencies, starts with correct dependency - update constructor, main code uses real data source, test code uses fake data source\
Not for injecting into activities and fragments because no easy way to change constructor (using FragmentScenario)\
Setter Injection\
Need to set dependency each time you make an instance of a class\
Documentation: https://developer.android.com/training/dependency-injection \
\
Need to have an common interface for the fake and real class (can right click class, refactor, extract interface)\
\
You can create a single generic ViewModelFactory that can generate any view model (sample: https://github.com/android/architecture-samples/tree/reactive)\
needed and an extension function (https://github.com/googlesamples/android-architecture/blob/reactive/app/src/main/java/com/example/android/architecture/blueprints/todoapp/util/FragmentExt.kt)\
\
Fragment Integration Tests (since they are visual, you want to render it) - empty activity, test fragment/viewmodel, test double fake repository\
FragmentScenario\
AndroidX Test library to create fragments. Gives control over starting state and lifecycle. Compatible with both local and instrumented tests.\
Service Locator pattern\
A singleton whose purpose is to store and provide dependencies. Setter Injection requires setting dependency each time you make an instance of a class, but for service locator pattern you set all dependencies in beginning and used to be sure they are used everywhere.\
Only want one instance, so to make sure of this add it to the Application class. Use annotation @VisibleForTesting set - says to not use the set in the class but for testing it is needed.\
Espresso\
Android UI testing library used to interact with views and check their state. 4 parts - static espresso method, ViewMatcher, ViewAction, ViewAssertion. It is best to turn off animations, disable window animation scale, transition animation scale, and animator duration scale.\
Static Espresso Method: https://developer.android.com/reference/androidx/test/espresso/Espresso.html#onView%28org.hamcrest.Matcher%3Candroid.view.View%3E%29 \
ViewMatchers: https://developer.android.com/reference/androidx/test/espresso/matcher/ViewMatchers.html \
ViewAction: https://developer.android.com/reference/androidx/test/espresso/ViewAction.html \
ViewAssertion: https://developer.android.com/reference/androidx/test/espresso/assertion/ViewAssertions#matches \
Mockito & Testing Navigation\
Mockito is a framework for making test doubles but does makes more than just mocks. Mock is a test double that tracks which of its methods were called. Pass or fail a test depending on whether their methods were called correctly. Great for testing something like when a navigation occurs, for example.\
Mockito creates NavController mock, attach that mocked NavController to the fragment, then verify navigate() called with correct action and parameters.\
\
Generally you can annotate @SmallTest on unit tests, @MediumTest on instrumented tests, and @LargeTest for End-To-End (E2E) tests\
\
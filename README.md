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
Use the LiveDataTestUtil.kt file to keep the testing of LiveData simple and boiler plate code to a minimum in test files.
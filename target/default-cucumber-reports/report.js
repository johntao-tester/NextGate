$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/NextGateLogin.feature");
formatter.feature({
  "line": 1,
  "name": "Test NextGate MatchMetrix software",
  "description": "Testing login and home page",
  "id": "test-nextgate-matchmetrix-software",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "user is on NextGate login page",
  "keyword": "Given "
});
formatter.match({
  "location": "NextGateLoginSteps.user_is_on_NextGate_login_page()"
});
formatter.result({
  "duration": 5465115703,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Login using invalid username and valid password",
  "description": "",
  "id": "test-nextgate-matchmetrix-software;login-using-invalid-username-and-valid-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@loginWithWrongUsername"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "user input invalid userName \"username\"",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "user inputs valid password",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user should see \"The username or password is invalid.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "username",
      "offset": 29
    }
  ],
  "location": "NextGateLoginSteps.user_input_invalid_userName(String)"
});
formatter.result({
  "duration": 2480819504,
  "status": "passed"
});
formatter.match({
  "location": "NextGateLoginSteps.user_input_valid_userName_with_valid_password()"
});
formatter.result({
  "duration": 179917888,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "The username or password is invalid.",
      "offset": 17
    }
  ],
  "location": "NextGateLoginSteps.user_should_see(String)"
});
formatter.result({
  "duration": 10049609783,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//span[text() \u003d \u0027The username or password is invalid.\u0027]\"}\n  (Session info: chrome\u003d87.0.4280.88)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027MacBook-Pro-2.local\u0027, ip: \u00272600:8805:1600:2890:1120:bc4:21a7:60fc%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.12.6\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 87.0.4280.88, chrome: {chromedriverVersion: 87.0.4280.88 (89e2380a3e36c..., userDataDir: /var/folders/dn/kj0c6c3d37v...}, goog:chromeOptions: {debuggerAddress: localhost:53524}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 0d6b0b087e51fc9b37e35b557431969a\n*** Element info: {Using\u003dxpath, value\u003d//span[text() \u003d \u0027The username or password is invalid.\u0027]}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy16.getText(Unknown Source)\n\tat com.nextgate.cucumber.steps.NextGateLoginSteps.user_should_see(NextGateLoginSteps.java:69)\n\tat ✽.Then user should see \"The username or password is invalid.\"(src/test/resources/features/NextGateLogin.feature:26)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 603952654,
  "status": "passed"
});
});
## Introduction
- 🔭 I’m currently working on 🤖 [RestAssured](https://github.com/asingh403/RestAssured_Practice_Oct2021/)
- 🌱 I’m currently learning  RestAssured 
- 🏋️ Learn everyday!

# 100_Days_API_TestingRestAssured <img src="https://github.com/ABSphreak/ABSphreak/blob/master/gifs/Hi.gif" width="30px">



<img src="https://cdn.springpeople.com/media/Rest Assured.png" width="120px;"/>
<img align="right" width=300px alt="Unicorn" src="https://media.giphy.com/media/3ohs4BSacFKI7A717y/giphy.gif" width="100px;"/>


##  Progress ⏳

### Day 1

- [OAuth2.0 - Youtube](https://youtu.be/2JlL_PvysGk)
- [OAuth2.0 - RestAssured Docs](https://github.com/rest-assured/rest-assured/wiki/Usage#oauth)
- [What is a REST API? | CRUD APIs| REST vs HTTP](https://youtu.be/nUuAWn0AAiY?t=50)

### Day 2
- [Request Specification](https://youtu.be/Xhswpwvu7o4)
- [StackOverFlow](https://stackoverflow.com/questions/54130713/can-we-build-requestspecification-of-io-restassured-in-step-by-step-manner)</a>
- [RestAssured Javadoc](https://www.javadoc.io/doc/io.rest-assured/rest-assured/latest/io/restassured/specification/RequestSpecification.html#spec-io.restassured.specification.RequestSpecification-)

    - RequestSpecification
    - RequestBuilder


### Day 3
- [POST Request BDD Style - makeseleniumeasy blog ](http://makeseleniumeasy.com/2019/11/19/rest-assured-tutorial-8-bdd-style-in-rest-assured/)
- [POST Call Practice](https://github.com/asingh403/RestAssured_Practice_Oct2021/tree/master/src/test/java/com/rest/api/post)

    - Post Request and assertation
    - Post Request with ".json" in "new File" and sending the request
- [Schema Validation Tests](https://github.com/asingh403/RestAssured_Practice_Oct2021/tree/master/src/test/java/com/rest/api/schema)
- [Schema files to Validate](https://github.com/asingh403/RestAssured_Practice_Oct2021/tree/master/src/test/resources)

- [POJO ](https://www.youtube.com/watch?v=bgyxCGNjhqg&ab_channel=RetargetCommon)

    - [Getter & Setters for POJO](https://github.com/asingh403/RestAssured_Practice_Oct2021/blob/master/src/test/java/com/rest/api/post/User.java)
    - [Generating JSON using POJO class](https://github.com/asingh403/RestAssured_Practice_Oct2021/blob/master/src/test/java/com/rest/api/post/POSTAPIWithPOJO.java)


### Day 4
- [DELETE Request Practice - YouTube](https://youtu.be/7RUzarUREpo)
- [PUT Request BDD Style - makeseleniumeasy blog ](http://makeseleniumeasy.com/2019/12/02/rest-assured-tutorial-10-lets-write-first-put-request-in-rest-assured/)


    - [PUT Request Tests - Git Repo](https://github.com/asingh403/RestAssured_Practice_Oct2021/tree/master/src/test/java/com/rest/api/put)
    - [DELETE Request - Git Repo](https://github.com/asingh403/RestAssured_Practice_Oct2021/tree/master/src/test/java/com/rest/api/delete)

### Day 5
- [Non-BDD Style - YouTube](https://www.youtube.com/watch?v=ZJBmggk7_3M&ab_channel=ExecuteAutomation)
- [JsonPath Parsing](https://devqa.io/parse-json-response-rest-assured/)

    - [Git Repo || Types of Authentication : basic | preemptive | digest | form | OAuth1 | OAuth2](https://github.com/asingh403/RestAssured_Practice_Oct2021/blob/master/src/test/java/com/rest/api/authentication/AuthApis.java)
    - [Git Repo || Non-BDD-Approach](https://github.com/asingh403/RestAssured_Practice_Oct2021/blob/master/src/test/java/com/rest/api/get/GETNONBDDAPI.java)
    

### Day 6
## **API Headers**
 - [API Header | YT Video](https://youtu.be/76CcJ90Lz4U?t=51)
1. **Request Header**
2. **Response Header**
3. **Payload Header**
4. **Representation Header**

**Request Header:** is Key: Value pair that is sent by client. So, the server can understand more about the request that client has placed.

**Response Header:** K:V is used by the server to give more context about the response.

**ETag:** Header in Response

~**Content/Type** is not a request-Header. it is categorized as one of the representation headers.~~

Accept-Encoding: **gzip** then it means it can understand compress data also.

**Representation Header:** Is talk about that the data has been transferred. It could be XML,JSON

```
  - Content-Encoding:gzip
  - Content/Type: Text/HTML
  - Chunked
  - Content-Length: 3545
  - Content-Range: bytes 50-1000/*
  - Content-Location: /docs/fo.xml
```
**Notes: We can customize the header: Example: Authorization.**

**Resource for more depth learning:** 

- [Mozilla Article | Web-API-Headers](https://developer.mozilla.org/en-US/docs/Web/API/Headers/Headers)

- [Mozilla Article | Web-HTTP-Headers](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers)
- [MDN | REST Concept](https://developer.mozilla.org/en-US/docs/Glossary/REST)

- [Retarget Common | RestAssured Series](https://www.youtube.com/playlist?list=PL-a9eJ2NZlbT0Hoo_Hj43utwgq2VusPyN)



**JSON Path generator and validator**
 - http://json2jsonpath.com/
 - https://jsonpathfinder.com/
 - https://jsonformatter.jsonparseronline.com/

**Learning Strategy**
- [Prepration Strategy](https://luck-artichoke-f18.notion.site/How-to-Study-and-prepartion-bba7737f280945768a0942a4e58829ac)
- [TestNG Runner-TC Execution](https://gist.github.com/asingh403/1ba6e2df93e0390d3c9a9b66840592d4)
- [TestNG Test from Java Main Method | journaldev](https://www.journaldev.com/21261/running-testng-tests-from-java-main-method)
- [TestNG Exection from Main Method | By Mukesh Otwani](https://learn-automation.com/how-to-execute-testng-xml-files-using-java-program/)
- [TestNG Runnner Execution | By Ashutosh](https://gist.github.com/asingh403/3e4b4644431af98feb75804bb84cb2a9)

**Multiple Type of Date Creation in Postman**
- [PreCondition: to Create date at RunTime](https://luck-artichoke-f18.notion.site/JS-to-Create-Multiple-Date-Type-Creating-Env-Variable-in-Postman-Passing-to-those-environment-Va-a19067a4b5e44adcbe1cb1df7836407a)
- [gist github to create date and Setting into Env. Variable](https://gist.github.com/asingh403/edf62d2b3b59eba01738ba03bc4bd543)
- [Notion Link](https://www.notion.so/JS-to-Create-Multiple-Date-Type-Creating-Env-Variable-in-Postman-Passing-to-those-environment-Va-a19067a4b5e44adcbe1cb1df7836407a)

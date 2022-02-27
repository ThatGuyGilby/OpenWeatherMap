# EmployeeCSVProject

## Table of Contents

> - [Summary](#Summary)
> - [Dependencies](#Dependencies)
> - [How to Set up the Project](#How-to-set-up-the-project)
> - [How to Use the Project](#How-to-use-the-project)
> - [Classes](#Classes)
> - [Testing and Outcome](#Testing-and-Outcome)
> - [Project Management](#Project-tasks-Management)

## Summary
> This program is a test framework for the Open Weather API. The test framework makes an API call
> and retrieves an API (HTTP) response and retrieve a JSON file, which will then be
> converted into a Data Transfer Object by accessing each values of the JSON Objects inside the JSON file.

## Dependencies
> + JUnit Jupiter - For unit testing
> + IO Cucumber - For user story testing
> + Jackson and JSON Simple - For rest API functionalities
>+ Mockito - For mocking values in tests
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.2</version>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.2.3</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.1</version>
</dependency>
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.2.3</version>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.3.1</version>
</dependency>
```

## How to set up the project

> 1. Click the green `Code` button in the top right corner of the screenshot below
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947263141228716082/unknown.png"/> </p>
> 2. Click the copy button to copy the url to your clipboard.
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947263513066352660/unknown.png"/> </p>
> 3. Open up a terminal and navigate to a directory of your choice. Then type `git clone` then paste the url.
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947264222570614824/unknown.png"/> </p>
> 4. Navigate the directory you cloned the project (In step #3) and open it up.
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947261936763023420/unknown.png"/> </p>
> 5. On IntelliJ, right-click the 'main' folder -> New -> Directory
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947266240685174805/unknown.png"/> </p>
> 6. Double-click the resources option to make a `resources` folder.
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947267293770023022/unknown.png"/> </p>
> 7. Create a file in the `resources` you made and name it `api.properties` and insert "api_key=" + your Open Weather Map API key

## How to use the project

> 1. Run all the JUnit tests and BDD tests to test the Open Weather API framework
> 2. Additionally, you can test it manually by running the `WeatherMainClass` or by doing the following
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947475119943581706/unknown.png"/> </p>
> 3. 
## Classes

> + DataTransferObject
>> A class that follows a `design pattern` where it acts like a `data structure`, allowing multiple
>> classes to be stored in a singular class for developers and testers to have easy and fast access on specific
>> classes and attributes that the Data Transfer Object contains
> + ConnectionManager
>> The class which makes the Open `Weather API call` with the correct `API key `and receives the `HTTP response`
>> based off the current weather in the location given in the link. This class also provides the necessary methods
>> to extract the JSON `object/arrays and values` within the JSON file that the response returns
> + Injector
>> The class which takes in the HTTP response through the connection manager and convert the values
>> it gets from the JSON objects into the attributes of the Data Transfer Object class
> + Weather DTO attribute classes
>> Classes which represents the attributes of a weather, such as the `wind` class which has the attributes
>> of speed and degrees

## Testing and Outcome


## Project Tasks Management

> The team used Trello in order to manage and keep track of all the tasks from the requirements in this project
> where each task is assigned to at least one member of our team. Since the project is small, the Trello
> board will look smaller than usual
> 
> Before:
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947473317168832532/unknown.png"/> </p>
>
> After:
>
>> <p align="center"> <img src="https://cdn.discordapp.com/attachments/935470190127353868/947473209018687488/unknown.png"/> </p>

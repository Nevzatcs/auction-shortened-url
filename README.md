# Url Shortener App

> Url shortener app is used for shorten website urls.
<p align="center">
  <a href="">
    <img src="https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square" />
  </a>
  <a href="https://github.com/Nevzatcs/auction-shortened-url/blob/main/LICENSE">
    <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-yellow.svg" target="_blank" />
  </a>
  <a href="">
    <img src="https://codecov.io/gh/kefranabg/readme-md-generator/branch/master/graph/badge.svg" />
  </a>
</p>

- [✨ Preview](#demo-preview)
- [📥 Installation](#installation)
- [🚀 Usage](#usage)
- [⚙️ API Example](#contribute)
- [⚙️ Tech Stack](#contribute)

- [🤝 Contributing](#license)
- [⌨️ Author](#footer)
- [📝 License](#license)

[(Back to top)](#table-of-contents)
## ✨ DB Preview
- User table




- Url table


## 📥 Installation

- You should have JDK 1.8 on your computer to built the project.
 
  [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)

- Clone the repo

```
git clone https://github.com/Nevzatcs/auction-shortened-url.git
```

- On a separate terminal and since this is a maven project you just need to go to the root of the project and perform the
  command:

```
mvn clean install
```

- or if you don't have installed maven on your OS

```
mvnw clan install
```

- This will run the unit tests of the project and create the jar file.

[(Back to top)](#table-of-contents)
## 🚀 Usage
- After having the jar file you can simply run:

```
java -jar target/url-shortener-app-0.0.1-SNAPSHOT.jar
```

- Since this is a Spring Boot project, you can also run the project with below command;

```
mvn spring-boot:run
```

- or if you don't have installed maven on your OS

```
mvnw spring-boot:run
```
[(Back to top)](#table-of-contents)
## ⚙️ API Example
- The project will run on port 8080 (configured as default).

- Users

Add new User 
```  
POST user/signup 
{
  "username":"username",
  "password":"password",
} 
  ```

- Urls

Create ShortUrl
```
POST user/1/url/create
{
"url: "https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular"
}
  ```
Redirection to real Url

```
GET http://localhost:8080/s/XXXyyyZZZZ 
  ```

Show user's all shortened Url's 

```
GET user/{userId}/url/list 
  ```
Show user's  one of shortened Url detail

```
GET user/{userId}/url/detail/{urlId}
  ```

Delete user's one of shortened urls
```
DELETE user/{userId}/url/detail/{urlId}
 ```

[(Back to top)](#table-of-contents)
## ⚙️ Tech Stack
- Java 8
- Spring Boot
- Spring Web
- Mapstruct
- JUnit
- Maven
- JPA / Hibernate
- Mockito
- MySQL


[(Back to top)](#table-of-contents)





## 🤝 Contributing
1. Fork it (<https://github.com/Nevzatcs/auction-shortened-url.git/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

[(Back to top)](#table-of-contents)
## ⌨️ Author


👤 **Nevzat Can Samur**

- Github: [@Nevzatcs](https://github.com/Nevzatcs)
- Linkedin: [@nevzatcansamur](https://www.linkedin.com/in/nevzatcansamur/)

[(Back to top)](#table-of-contents)
## 📝 License


Copyright © 2021.

This project is [MIT](https://github.com/Nevzatcs/auction-shortened-url/blob/main/LICENSE) licensed.


---
[(Back to top)](#table-of-contents)

This README was generated with ❤️ 

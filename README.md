<h1 align="center">
Github Compose
<br>
<br>
<img src="https://github.com/Debanshu777/Compose-Github/blob/master/assets/GithubCompose.gif" />
</h1>

<p>
Github Compose is you way to track the traending chart on Github.The project is set towards using some of the latest packages and libraraties to consume 4 sperate apis for getting the data.</p>
<p>We are using <b>Ktor Client and SQLDelight</b> for all the heavy lifting with the help of both <b>Koin and Dagger Hilt implemention</b> binging in the freshness of <b>Material3</b>.</p>
<p>Made with ❤️ by <a href="https://github.com/Debanshu777">Debanshu777</a></p>

## Build with 🛠
- <a href="https://developer.android.com/jetpack/compose">Jetpack Compose</a> : Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
- <a href="https://m3.material.io/">Material3</a> : The Material 3 Design Kit is built to work with the Material Theme Builder Figma plugin. Select an image or color to visualize dynamic color in your UI.
- <a href="https://ktor.io/docs/getting-started-ktor-client.html">Ktor Clinet</a> : Ktor includes a multiplatform asynchronous HTTP client, which allows you to make requests and handle responses, extend its functionality with plugins, such as authentication, JSON serialization, and so on. In this tutorial, we'll create a simple client application for sending a request and receiving a response.
- <a href="https://cashapp.github.io/sqldelight/">SQLDelight</a> : SQLDelight generates typesafe kotlin APIs from your SQL statements. It verifies your schema, statements, and migrations at compile-time and provides IDE features like autocomplete and refactoring which make writing and maintaining SQL simple.
- <a href="https://insert-koin.io/">Koin</a> : Koin is a pragmatic and lightweight dependency injection framework for Kotlin developers.
- <a href="https://kotlinlang.org/docs/coroutines-overview.html">Coroutines</a> : A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously. Coroutines were added to Kotlin in version 1.3 and are based on established concepts from other languages.
- <a href="https://developer.android.com/kotlin/flow">Flow</a> : Flow is the Kotlin type that can be used to model streams of data. Just like LiveData and RxJava streams, Flow lets you implement the observer pattern: a software design pattern that consists of an object (a.k.a. observable, producer, source, emitter) that maintains a list of its dependents, called observers (subscribers, collectors, receivers, etc.), and notifies them automatically of any state changes. 
- <a href="https://developer.android.com/training/dependency-injection/hilt-android">Daggar Hilt</a> : Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Doing manual dependency injection requires you to construct every class and its dependencies by hand, and to use containers to reuse and manage dependencies.
- <a href="https://github.com/Kotlin/kotlinx.serialization">Kotlin serialization</a> : Kotlin serialization consists of a compiler plugin, that generates visitor code for serializable classes, runtime library with core serialization API and support libraries with various serialization formats.
- <a href="https://developer.android.com/jetpack/compose/navigation">Navigating with Compose</a> : The Navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component’s infrastructure and features.
- <a href="http://airbnb.io/lottie/#/android-compose">Lottie</a> : Lottie is a library for Android, iOS, Web, and Windows that parses Adobe After Effects animations exported as json with Bodymovin and renders them natively on mobile and on the web!
- <a href="https://coil-kt.github.io/coil/">Coil</a> : An image loading library for Android backed by Kotlin Coroutines.
- <a href="https://github.com/google/accompanist">Accompanist</a> : Accompanist is a group of libraries that aim to supplement Jetpack Compose with features that are commonly required by developers but not yet available.

## Setup
You don't have to do much setup for the project, just nedd to get the API key for <a href="https://rapidapi.com/targaryen.akane/api/github-trending">`github-trending`</a> from `Rapid API` it is free. Get the `RapidAPIHost` and `RapidAPIKey` then set it inside `local.properties`
```
RapidAPIHost=github-trending.p.rapidapi.com
RapidAPIKey=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```
For other usecases we are using public apis


## Want to Contribute ?
Awesome! If you want to contribute to this project, you're always welcome!
Have any questions, doubts or want to present your opinions, views? You're always welcome. You can mail me at <b>debanshudatta123@gmail.com</b> or make an issue.
Looking for contributors! Don't be shy. 😁 Feel free to open issues/pull requests to help me improve this project.

- When reporting a new Issue, make sure to attach Screenshots, Videos or GIFs of the problem you are reporting.
- When submitting a new PR, make sure tests are all green. Write new tests if necessary.

## License
```
MIT License

Copyright (c) 2022 Debanshu Datta

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

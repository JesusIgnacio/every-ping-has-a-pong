# Build a rest service from the command line, as simple as “every request has a response.”

Following with **Handmade Series with Java**, this is the 3rd chapter. I’ll make a rest service, as always, step by step, without IDEs.

I'll use the  [Spark](https://sparkjava.com/) library to getting a “pong” to every “ping” request.

I declare a simple class called PingPongGame with **main** method inside.

```java
public class PingPongGame {
    public static void main(String[] args) 
			//nothing inside yet
    }
}
```

Inside of the main method, call a static method named [get](https://sparkjava.com/documentation#routes) , provided by Spark library, that contains:

- A url path `/ping`.
- `GET` verb http.
- Receiving a `req` and `res` object from request.
- Which finally return a response, a simple string “pong”.

I add the current import from Spark library `spark.Spark.get`, getting the code above:

```java
import static spark.Spark.get;

public class PingPongGame {
    public static void main(String[] args) {
        get("/ping", (req, res) -> "pong!");
    }
}
```

Before executing it, download the spark library, from the maven repository.

After downloading it, place it inside PingPongGame class folder, it runs the next instruction through the command line

```bash
java -cp .\spark-core-2.9.3.jar .\PingPongGame.java
#it prints
Exception in thread "main" java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory
        at spark.Service.<clinit>(Service.java:58)
        at spark.Spark$SingletonHolder.<clinit>(Spark.java:54)
        at spark.Spark.getInstance(Spark.java:58)
        at spark.Spark.<clinit>(Spark.java:64)
        at HelloWorld.main(HelloWorld.java:5)
Caused by: java.lang.ClassNotFoundException: org.slf4j.LoggerFactory
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        at spark.Service.<clinit>(Service.java:58)
        at spark.Spark$SingletonHolder.<clinit>(Spark.java:54)
        at spark.Spark.getInstance(Spark.java:58)
        at spark.Spark.<clinit>(Spark.java:64)
        at HelloWorld.main(HelloWorld.java:5)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at jdk.compiler/com.sun.tools.javac.launcher.Main.execute(Main.java:404)
        at jdk.compiler/com.sun.tools.javac.launcher.Main.run(Main.java:179)
        at jdk.compiler/com.sun.tools.javac.launcher.Main.main(Main.java:119)
```

Cause Spark library by itself can’t run this instance, it depends on others libraries. The required jar libraries list:

- `slf4j-api`
- `spark-core`
- `javax.servlet-api`
- `jetty-server`
- `jetty-util`
- `jetty-http`
- `jetty-io`
- `log4j-slf4j-impl`
- `log4j-api`
- `log4j-core`

After downloading them, run the long command line above:

```bash
java -cp "spark-core-2.9.3.jar;slf4j-api-1.7.25.jar;
javax.servlet-api-3.1.0.jar;jetty-server-9.4.31.v20200723.jar;
jetty-util-9.4.31.v20200723.jar;jetty-http-9.4.31.v20200723.jar;
jetty-io-9.4.31.v20200723.jar;log4j-slf4j-impl-2.17.2.jar;
log4j-api-2.17.2.jar;log4j-core-2.17.2.jar" .\PingPongGame.java
#It prints nothing because the process has started to run, leaving the terminal in a waiting state.
```

So, at this point, I need to verify if the rest service is “up & running” by executing this command:

```bash
curl http://localhost:4567/ping
#it should prints
pong!
```

Again, simple and effective, perhaps not too simple cause of the amount of added libraries, but still isn't to worry taking in count it made without IDEs.

**That’s all!**

1. **Pong** to my **ping** needed.
2. Creating a standar rest services.
3. Using a method of a knowing library.
4. Add it and test it.
5. Problem happened(missing libraries).
6. Adding missing libraries.
7. Problem fixed.
8. I got my **pong** trought rest service.

 **Command and options dictionary:**

- `java` run .class and .java files.
- `-cp`indicate compiled folders directory(classpath).
- `curl` command to execute transfer to or from a server.

**Tech stack**

- Java 11.
- Windows 10.
- [Spark-java](https://sparkjava.com/).

**Bonus track**

Spark-java is a “microframework” as springboot but only based on functional programming with a simple implementation, I invited you to take in count in your read list the next article, to a deeper understanding.

[Web microservices development in Java that will Spark joy](https://blogs.oracle.com/javamagazine/post/web-microservices-development-in-java-that-will-spark-joy)

kloutapi for Java
=============

A Java library for the [Klout](http://www.klout.com) API. 
Released under the Apache License 2.0.

Sample
-------

Retrieving klout scores is easy as:

    Klout k = new Klout("YOURKEY");

    List<String> users = new Vector<String>();
    users.add("charliesheen");
    users.add("ashtonkutcher");

    List<KloutUser> ret = k.klout(users);
    for (KloutUser u : ret)
    {
        System.out.println(u);
    }

Implemented methods
-------

* Score: klout
* User: show

Installation Guide
-------

kloutapi is currently deployed in a custom maven repository hosted at
github. You can either download the JAR manually from this
[link](http://thiagoncc.github.com/kloutapi/repository/com/github/thiagoncc/kloutapi/)
or install the following repository and dependency in your pom.xml:

    <repositories>
        <repository>
          <id>kloutapi-repo</id>
          <name>kloutapi repository on GitHub</name>
          <url>http://tncardoso.github.com/kloutapi/repository/</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.thiagoncc</groupId>
            <artifactId>kloutapi</artifactId>
            <version>0.1</version>
        </dependency>
    </dependencies>

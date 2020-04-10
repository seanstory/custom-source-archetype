# Custom API Source Archetype - for Elastic Workplace Search

### Dependencies
This project makes use of the [Workplace Search Java](https://github.com/seanstory/workplace-search-java) project.
Until such a time that the artifact makes it into maven central, you will need to clone and build that project before you
can build this one.

### Usage
To build, clone this repo and then:

    mvn clean install
    cd ..
    mvn archetype:generate -DarchetypeCatalog=local
    
And answer the prompts. This will generate a new directory with the same name as your specified `artifactId`.

### What's it for?
[Elastic Workplace Search](https://www.elastic.co/guide/en/workplace-search/current/workplace-search-getting-started.html)
supports a variety of [Content Sources](https://www.elastic.co/guide/en/workplace-search/current/workplace-search-content-sources.html),
but for any sources that aren't supported "out of the box", it also provides APIs for indexing documents from custom sources.

This archetype helps to bootstrap the development of such a [Custom API Source](https://www.elastic.co/guide/en/workplace-search/current/workplace-search-custom-api-sources.html).

This might be a good place to start if you are looking for an example of a Custom API Source, or if you want to develop
a Custom API Source in Java, Kotlin or Groovy.

### What's in it?

The contents of the resulting project will look something like:

```
.
├── README.md
├── custom-source-example-core
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── example
│       │   │       ├── document
│       │   │       │   └── HelloWorldDocument.java
│       │   │       └── sources
│       │   │           └── HelloWorldSource.java
│       │   └── resources
│       │       └── sources
│       └── test
│           ├── java
│           │   └── example
│           │       └── run
│           │           └── SyncTest.groovy
│           └── resources
│               ├── logback.groovy
│               └── test.yml
├── custom-source-example-dist
│   ├── pom.xml
│   └── src
│       └── main
│           ├── README.md
│           ├── assembly
│           │   └── assembly.xml
│           ├── bin
│           │   └── sync
│           └── config
│               ├── logback.groovy
│               └── source.yml
└── pom.xml
```

The project has two modules. The `${artifactId}-core` module contains a "hello world" example of using the [Workplace Search
Java](https://github.com/seanstory/workplace-search-java) client and SDK libraries. This example has a single implementation
of a `Document`, and a single implementation of a `Source` in the `main/` sources, and a single [Spock](http://spockframework.org/spock/docs/1.3/all_in_one.html)
test in the test sources.

The `${artifactId}-dist` module is intended to provide an easy way to distribute and run the Custom API Sources defined in the other module.
Defined by the `src/main/assembly/assembly.xml`, this module builds a Tarball of all the necessary libraries and configurations,
and provides a `bin/sync` executable to easily run your content source.

### Known Usages
Looking for a real-world example? The below are known projects that leveraged this archetype to get started. If you use this
project and want to share your successes with the community, open a PR to add a link!

* [Custom Source Example](https://github.com/seanstory/ws-custom-source-example) (the genesis of this project)
* [Filesystem Souce](https://github.com/seanstory/filesystem-workplace-search-source)

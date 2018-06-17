# Hello World in Scala using GraalVM native-image 

This is just a fork of https://github.com/Viewtiful/hello-world-scala-graalvm 
But using mill instead of sbt and manual commands


## Install GraalVM
1. Three possibilities here:

   * Install GraalVM Enterprise Edition for your operating system by downloading a pre-built version: http://www.oracle.com/technetwork/oracle-labs/program-languages/downloads/index.html
   * Install GraalVM Community Edition from the official Github repository: https://github.com/oracle/graal/releases (only a Linux version is for the moment available)
   * Cloning and building your version of GraalVM from the official Github repository: https://github.com/oracle/graal
 
2. Extract the archive

3. Finally simply export the `bin` folder to your `PATH`
  * Linux: `export PATH="/path/to/graalvm/bin:$PATH"`
  * Mac OS: `export PATH="/path/to/graalvm/Contents/Home/bin:$PATH"`

**Do not forget to add the command line above to your `~/.profile` for future usage**

Check that everything is correct with `echo $PATH`

## Create a fat JAR of the project

We are using `mill hello.native` to create a native executable for us.


You should see the following output:

```
[25/34] hello.compile 
Compiling compiler interface...
warning: there was one deprecation warning (since 2.11.0)
warning: there were four deprecation warnings (since 2.12.0)
warning: there were 5 deprecation warnings in total; re-run with -deprecation for details
warning: there were three feature warnings; re-run with -feature for details
four warnings found
[info] Compiling 1 Scala source to /Users/jonas.depop/hacks/hello-world-scala-graalvm/out/hello/compile/dest/classes ...
[info] Done compiling.
[34/34] hello.native 
Build on Server(pid: 72100, port: 64514)
   classlist:     226.91 ms
       (cap):   1,059.60 ms
       setup:   1,642.86 ms
  (typeflow):   4,681.84 ms
   (objects):   1,568.71 ms
  (features):      38.31 ms
    analysis:   6,410.00 ms
    universe:     222.44 ms
     (parse):   1,667.38 ms
    (inline):     969.33 ms
   (compile):  15,318.66 ms
     compile:  18,354.98 ms
       image:   1,655.14 ms
       write:   1,337.20 ms
     [total]:  29,883.95 ms
```



## Executing the native image

A simple `./out/hello/native/dest/hello` will do the job :smile:

Check the time it takes for the program to execute!
`time ./out/hello/native/dest/hello`

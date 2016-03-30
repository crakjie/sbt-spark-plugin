#Description
This is a simple sbt plugin, which will simplify your life to submit your spark code.
By filling the --jar option of the spark-submit command.

#Usage
In your build.sbt specifty your sparkHome directory
```
sparkHome := "/toto/titi"
```
warn : This spark home will not set your other 'sparkHome' env ( maybe in a next version )

In your plugin.sbt add the plugin
```
addSbtPlugin("com.github.crakjie" % "sbt-spark-plugin" % "1.1.0")
```

Execute the submit command.

```
sbt clean package submit
```

## Params
You can add others submit params by setting directly
```
submitOptions := "--master local[8]  --executor-memory 20G --verbose --conf 'spark.executor.extraJavaOptions=-XX:+PrintGCDetails -XX:+PrintGCTimeStamps'"
```

#See your submit cmd
If you ever want to see your command submit
```
logLevel := Level.Debug
submitLogLevel := Level.Debug
```

#Send params to your spark program.
Give params space separated. And they will be usable from your main args array.
```
sbt package "submit <arg1> <arg2>"
```
#Why it's good
This plugin use the command spark-submit without making an über jar, witch is relatively fastest.

#Why it's could be better
Because the plugin push all your classpath . But however it's still faster than create an assambly.


#How it's work

The plugin will fill the --jar option of spark-submit with the class path generated by sbt.

#Send param to you main.
```
sbt package "submit arg1 arg2"
```

# WithZoneErrorExample

Sample project that showcases an jdk issue in DateTimeFormatter.withZone.  
JDK bug: https://bugs.openjdk.java.net/browse/JDK-8177021

The issue is present in the android java.time library, as well as in the [desugar_jdk_libs](https://github.com/google/desugar_jdk_libs).

The [`DateTimeFormatterTest`](https://github.com/inv3rse/WithZoneErrorExample/blob/master/app/src/test/java/com/inverse/cc/withzoneerrorexample/DateTimeFormatterTest.kt#L30) will fail if run on jdk8, but succeed on later versions.  
In contrast it works fine in the ThreeTen implementation in the [`ThreeTenDateTimeFormatterTest`](https://github.com/inv3rse/WithZoneErrorExample/blob/master/app/src/test/java/com/inverse/cc/withzoneerrorexample/ThreeTenDateTimeFormatterTest.kt).

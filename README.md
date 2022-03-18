clone repo
add *.txt file in src/test/resources with text what you want to rewrite to .xls file
add *.xls file in any directory
in src/test/java/WriterTest.java set value for fileSourcePath varible (variable with absolute path to .xls file where need to write text )
run in terminal for tests: .\gradlew test 

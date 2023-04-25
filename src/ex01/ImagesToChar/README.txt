javac -d target src/java/Logic.java
javac -d target -cp target src/java/Program.java
jar -cvfm target/images-to-chars-printer.jar src/manifest.txt -C target edu/school21/printer/app/Program.class target/edu/school21/printer/logic/Logic.class
jar tf target/images-to-chars-printer.jar
cp -a src/resources target/resources
java -jar target/images-to-chars-printer.jar . O
javac -d target src/java/Logic.java
javac -d target -cp target:lib/jcommander-1.78.jar:lib/JCDP-2.0.1.jar src/java/Program.java
unzip -qq -o -d target lib/jcommander-1.78.jar
unzip -qq -o -d target lib/JCDP-2.0.1.jar
rm -rf target/META-INF
jar -cvfm target/images-to-chars-printer.jar src/manifest.txt -C target .
jar tf target/images-to-chars-printer.jar
cp -a src/resources target/resources
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
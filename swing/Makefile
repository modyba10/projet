JC = javac
JVM = java

.SUFFIXES: .java .class

.java.class:
	$(JC) $*.java

CLASSES = \
    Client.java \
    MediaPlayerGUI.java

MAIN = MediaPlayerGUI

default: run

run: $(CLASSES:.java=.class)
	@$(JVM) $(MAIN)

clean:
	@rm -f *.class

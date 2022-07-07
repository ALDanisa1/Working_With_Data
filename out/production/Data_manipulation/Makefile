# binary search program makefile
# Hussein Suleman
# 27 March 2017

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: BinaryTreeNode.class BinaryTree.class \
         BTQueueNode.class BTQueue.class \
         AVLTree.class AVLTreeTest.class

default: $(CLASSES)

clean:
	rm *.class

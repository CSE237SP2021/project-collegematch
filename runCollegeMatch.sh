#!/bin/bash

git checkout development
javac src/collegematch/*.java
java -cp src collegematch.Menu
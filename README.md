# Cleaner [![Build Status](https://travis-ci.org/Noviv/Cleaner.svg?branch=master)](https://travis-ci.org/Noviv/Cleaner)

A text and GUI based tool that finds all useless/empty files and directories and can remove them.<br>

## Run
1. Download Cleaner.jar from the dist folder.
2. Place the jar in any folder of the drive you want it to clean.
3. Run using one of the two methods described below.

<br>
<br>
<br>

## Command-based usage:<br>
  <code>java -jar Cleaner.jar [excludedPaths] [-option]</code>
<br><br>
Options:<br>
<code>-f: File cleaner</code><br>
<code>-d: Directory cleaner</code><br>
<code>-b: Both</code><br>

Example:<br>
<code>java -jar Cleaner.jar C:/Users/Admin/Documents/file.txt,C:/Users/Admin/Downloads -f</code>

<br>
<br>
<br>

## GUI-based usage:
<code>java -jar Cleaner.jar</code>

OR double click jar

# JavaLeak
Simple command line application demonstrating how Java leaks sensitive data Strings in memory. 
The application writes a password to either a String or Char array depending on the user's selection. 
The application then sets the String to null, or wipes the Char array allowing the user to see how the sensitive password is handled in memory.
# Setup
To run this demo, download and run the JavaLeak.jar file via `java -jar JavaLeak.jar`
The application provides the following options:

* Select 1 to save password in String
* Select 2 to save password in char array
* Select 3 to call the garbage collector
* Select 4 to write bulk data to heap
* Select 0 to exit

Selecting option 1 saves the password `S3cr3tP@ssw0rd` to a string and then sets the string to null. 
The JMap utility may be used to dump the process's heap and find the sensitive String which will remain in memory until the garbage collector disposes of it.

`jhsdb jmap --pid=<process_id> --binaryheap && strings heap.bin | grep S3cr3tP@ssw0rd`

To find the process ID on a *nix system, run `ps -e | grep java`

Selecting option 2 will save the password in a Char array and then wipe the array. This prevents the password from being leaked in memory and is a secure alternative to using Java Strings.

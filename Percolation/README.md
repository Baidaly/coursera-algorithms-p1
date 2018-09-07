**Specification**
-----------------

Here is the programming assignment [specification](http://coursera.cs.princeton.edu/algs4/assignments/percolation.html) that describes the assignment requirements.

Be sure that your code conforms to the prescribed APIs: each program must be in the "default" package (i.e., no **package** statements) and include only the public methods and constructors specified (extra private methods are fine). Note that **algs4.jar** uses a "named" package, so you must use an **import** statement to access a class in **algs4.jar**.

**Checklist**
-------------

The [checklist](http://coursera.cs.princeton.edu/algs4/checklists/percolation.html) contains frequently asked questions and hints. If you're not sure where to start, see the section at the end of the checklist.

**Testing**
-----------

The file [percolation-testing.zip](http://coursera.cs.princeton.edu/algs4/testing/percolation-testing.zip "percolation project") contains sample data files and programs that you can use to test Percolation.java.

**Web Submission**
------------------

Submit a zip file named **percolation.zip** that contains only the two source files **Percolation.java** and **PercolationStats.java**. Here are three approaches to creating the zip file:

Mac OS X.

*   Select the required files in the Finder.
*   Right-click and select _Compress 2 Items_.
*   Rename the resulting file to **percolation.zip**.

Windows.

*   Select the required files in Windows Explorer.
*   Right-click and select _Send to -> Compressed (zipped) folder_.
*   Rename the resulting file to **percolation** (the .zip extension is automatic).

Command line (Linux or Mac OS X).

*   Change to the directory containing the required .java files.
*   Execute the command: **zip percolation.zip Percolation.java PercolationStats.java**

**Assessment Report**
---------------------

Here is some information to help you interpret the assessment report. See the [Assessment Guide](https://www.coursera.org/learn/algorithms-part1/resources/R2mre) for more details.

*   _Compilation_: we compile your .java files using a Java 8 compiler. Any error or warning messages are displayed and usually signify a major defect in your code. If your program does not compile, no further tests are performed.
*   API: we check that your code exactly matches the prescribed API (no extra methods and no missing methods). If it does not, no further tests are performed.
*   _Bugs_: we run [Spotbugs](https://spotbugs.github.io "Spotbugs home page") to check for common bug patterns in Java programs. A warning message strongly suggests a bug in your code but occasionally there are false positives. Here is a summary of [bug descriptions](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html "Spotbugs bug descriptions"), which you can use to help decode warning messages.

*   _Style_: we run [checkstyle](http://checkstyle.sourceforge.net) to automatically checks the style of your Java programs. Here is a list of available [Checkstyle checks](http://checkstyle.sourceforge.net/checks.html "Checkstyle checks"), which you can use to help decode any warning messages.

*   _Correctness_: we perform a battery of unit tests to check that your code meets the specifications.
*   _Memory_: we determine the amount of memory according to the 64-bit memory cost model from lecture.
*   _Timing_: we measure the running time and count the number of elementary operations.
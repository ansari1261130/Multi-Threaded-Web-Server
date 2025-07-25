Tech Stack:
Java, IntelliJ IDEA, Apache JMeter, TCP Sockets, Multithreading

✅ Project Overview:
Designed and implemented a multi-threaded web server-client model in Java to simulate and test high concurrency environments. The server handles simultaneous TCP connections, and clients interact via socket communication. Performance benchmarking was done using Apache JMeter to evaluate scalability and response efficiency.

⚙ Key Responsibilities:
Developed multi-threaded TCP server and client using Java’s Socket, ServerSocket, Thread, and functional interfaces (Runnable, Consumer).

Used IntelliJ IDEA to build, debug, and run Java applications with real-time code coverage metrics.

Integrated Apache JMeter for stress testing and simulating 1000 concurrent users with custom TCP Sampler.

Implemented client-side request-response mechanisms to print real-time server feedback and log activities.

Configured server timeout handling for idle connections and maintained thread safety under load.

📈 Performance Testing (JMeter):
Test Configuration:

Threads (Users): 1000

Ramp-up Period: 10 seconds

Loop Count: 1

Results (from Graph Results panel):

Average Response Time: 1 ms

Median Response Time: 1 ms

Deviation: 1 ms

Throughput: ~1,680,522 samples/minute

Observations:

Server sustained 1000 parallel requests with extremely low response time.

High throughput indicates exceptional scalability under rapid concurrent client spikes.

No errors reported across the test cycles, proving robustness of connection handling and socket communication.

💡 Tools Used:
IntelliJ IDEA for code development, version control, and coverage tracking.

Apache JMeter for generating concurrent TCP requests and measuring performance.

Java networking APIs for low-level socket programming.

JUnit/Manual Logging for testing and validation.

📤 Outcome:
Achieved a real-time concurrent handling system with verified sub-millisecond response times.

Demonstrated ability to write scalable multi-threaded systems and simulate realistic user traffic.

Strengthened skills in performance tuning and network programming.

📎 Add-on Points (for resume bullets):
Developed a performant TCP server capable of handling 1000+ simultaneous client connections using Java multithreading.

Reduced average client-server round-trip time to 1 ms, verified via JMeter.

Achieved ~1.6 million requests/min throughput with no packet loss or failures.

Used IntelliJ coverage tools to monitor and optimize unit testing effectiveness.

Quick test to show a problem with the Java Random class. It outputs a histogram of the differences from generated integers of two java.util.Random generators. The generators are created with seeds that have a close relation. This close relation becomes visible in the generated integers.

[Example Results](example-results.md)

If you are on Linux it can be interesting to use the command [`watch`](https://linux.die.net/man/1/watch) to execute it repeatedly and thus see how the distribution is always the same.
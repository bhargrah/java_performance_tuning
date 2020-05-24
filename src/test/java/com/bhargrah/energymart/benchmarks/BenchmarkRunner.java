package com.bhargrah.energymart.benchmarks;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(ArrayListBenchMark.class.getSimpleName())
                .include(HashcodeBenchMark.class.getSimpleName())
                .include(ComparableHashmapBenchMark.class.getSimpleName())
                .forks(1)
                .jvmArgsAppend("-Djava.io.tmpdir=/Users/rahulbhargava/Desktop/git_repo/java/java-performance-tuning/src/test/results")
                .build();

        new Runner(opt).run();
    }
}

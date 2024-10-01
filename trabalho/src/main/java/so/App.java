package so;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread) //significa que cada thread terá sua própria instância da classe
public class App 
{
    // Estressará a CPU, usa a lib JMH - Java Microbenchmark Harness
    // Método que simula uma operação de carga pesada
    // O método stressCpu() contém uma simulação de uma operação pesada de CPU, e o JMH vai medir o desempenho dele
    @Benchmark
    @Warmup(iterations = 10, time = 10, timeUnit = TimeUnit.SECONDS) // Fase de aquecimento para aquecer a JVM - vai rodar 3 iterações de "warmup"
    @Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS) // Fase de medição - essas iterações são usadas para coleta de dados que serão exibidos no relatório final.
    @Fork(1) // Número de forks, ou seja, execuções independentes
    @OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo de saída
    public void stressCpu() {
        int result = 0; 
        for (int i = 0; i < 100_000_000; i++) {
            double a = Math.random();
            double b = Math.random();
            // Adicionando operações matemáticas mais complexas
            result += Math.sin(a * b) * Math.log(a + 1) * Math.sqrt(b + 1);
        }
    }
}

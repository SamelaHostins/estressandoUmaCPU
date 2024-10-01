package so;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    
    /*
     * JMH faz várias execuções (forks), com fases de aquecimento (warmup) e
     * medição (measurement), garantindo que os resultados sejam estáveis e confiáveis.
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(App.class.getSimpleName()) // Executar o benchmark da classe App
            .forks(1) // Número de forks - especifica que haverá uma única instância 
            .build();

        new Runner(opt).run(); // Rodar o benchmark
    }
}

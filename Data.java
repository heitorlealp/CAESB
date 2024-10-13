import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Data {

    public static void main(String[] args) {
        // Define a data atual para teste (substitua por qualquer data que você queira testar)
        LocalDate dataAtual = LocalDate.of(2024, 7, 7); // Por exemplo, domingo antes do Natal

        // Lista de feriados e pontos facultativos
        List<LocalDate> datasEspeciais = Arrays.asList(
            LocalDate.of(2024, 1, 1),  // Confraternização Universal
            LocalDate.of(2024, 2, 12), // Carnaval (ponto facultativo)
             LocalDate.of(2024, 2, 13), // Carnaval (ponto facultativo)
            LocalDate.of(2024, 2, 14), // Quarta-feira de cinzas (ponto facultativo até as 14 horas)
            LocalDate.of(2024, 3, 29), // Paixão de Cristo
            LocalDate.of(2024, 4, 21), // Tiradentes e Aniversário de Brasília
            LocalDate.of(2024, 5, 1),  // Dia Mundial do Trabalho
            LocalDate.of(2024, 5, 30), // Corpus Christi (ponto facultativo)
            LocalDate.of(2024, 5, 31), // Ponto facultativo
            LocalDate.of(2024, 9, 7),  // Independência do Brasil
            LocalDate.of(2024, 10, 12), // Nossa Senhora Aparecida
            LocalDate.of(2024, 10, 28), // Dia do Servidor Público
            LocalDate.of(2024, 11, 2),  // Finados
            LocalDate.of(2024, 11, 15), // Proclamação da República
            LocalDate.of(2024, 11, 20), // Dia da Consciência Negra
            LocalDate.of(2024, 11, 30), // Dia do Evangélico
            LocalDate.of(2024, 12, 24), // Véspera de Natal (ponto facultativo após as 14 horas)
            LocalDate.of(2024, 12, 25), // Natal
            LocalDate.of(2024, 12, 31)  // Véspera do Ano Novo (ponto facultativo após as 14 horas)
        );

        // Obter a data de amanhã com base na data atual
        LocalDate dataAmanha = dataAtual.plusDays(1);
        
        // Verificar se a data de amanhã é no fim de semana ou um feriado/ponto facultativo
        boolean isDataEspecial = datasEspeciais.contains(dataAmanha) || 
                                 dataAmanha.getDayOfWeek() == DayOfWeek.SATURDAY || 
                                 dataAmanha.getDayOfWeek() == DayOfWeek.SUNDAY;

        // Definir o formato da data e do dia da semana
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEEE");
        
        // Formatar a data e o dia da semana
        String dataFormatada = dataAmanha.format(formatter);
        String diaDaSemana = dataAmanha.format(dayOfWeekFormatter);
        
        // Determinar a data útil seguinte
        while (datasEspeciais.contains(dataAmanha) || 
               dataAmanha.getDayOfWeek() == DayOfWeek.SATURDAY || 
               dataAmanha.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dataAmanha = dataAmanha.plusDays(1);
        }
        
        String dataUtilFormatada = dataAmanha.format(formatter);
        String diaUtilDaSemana = dataAmanha.format(dayOfWeekFormatter);
        
        // Determinar a mensagem com base no dia da semana
        String mensagem;
        if (isDataEspecial) {
            // Se amanhã for um dia especial (fim de semana ou feriado), mostre o próximo dia útil
            mensagem = String.format("Bom dia, %s, dia %s, faremos uma vistoria no seu imóvel.", diaUtilDaSemana, dataUtilFormatada);
        } else {
            // Se amanhã for um dia útil normal, use "amanhã"
            mensagem = String.format("Bom dia, amanhã, dia %s, faremos uma vistoria no seu imóvel.", dataFormatada);
        }
        
        // Exibir a mensagem
        System.out.println(mensagem);
    }
}
# 📅 Projeto de Verificação de Dias Úteis em Java

Este projeto Java foi desenvolvido para **facilitar meu trabalho na Caesb**, automatizando a verificação de dias úteis, considerando finais de semana e feriados/pontos facultativos. 

## 🛠️ Funcionalidades:
- Verifica se a data de amanhã é um feriado, ponto facultativo ou fim de semana.
- Se amanhã não for um dia útil, exibe a próxima data útil.
- Mensagens customizadas para notificar sobre eventos futuros, como vistorias.

## 📋 Como Usar:
1. Clone este repositório.
2. Compile e execute o arquivo `Data.java` na sua IDE favorita.
3. Modifique a data no código para realizar testes com diferentes dias.

## 🔧 Código:
```java
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Data {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.of(2024, 7, 7); 
        List<LocalDate> datasEspeciais = Arrays.asList(
            LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 12), LocalDate.of(2024, 2, 13),
            LocalDate.of(2024, 2, 14), LocalDate.of(2024, 3, 29), LocalDate.of(2024, 4, 21),
            LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 30), LocalDate.of(2024, 5, 31),
            LocalDate.of(2024, 9, 7), LocalDate.of(2024, 10, 12), LocalDate.of(2024, 10, 28),
            LocalDate.of(2024, 11, 2), LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 20),
            LocalDate.of(2024, 11, 30), LocalDate.of(2024, 12, 24), LocalDate.of(2024, 12, 25),
            LocalDate.of(2024, 12, 31)
        );

        LocalDate dataAmanha = dataAtual.plusDays(1);
        boolean isDataEspecial = datasEspeciais.contains(dataAmanha) || 
                                 dataAmanha.getDayOfWeek() == DayOfWeek.SATURDAY || 
                                 dataAmanha.getDayOfWeek() == DayOfWeek.SUNDAY;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

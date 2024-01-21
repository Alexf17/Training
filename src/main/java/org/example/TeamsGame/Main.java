package org.example.TeamsGame;


public class Main {


    public static void main(String[] args) {

        Handler.start();

        System.out.println("-----------------Teams with max score------------------------------------");
//          Найти команду с максимальными баллами:
        Streams.maxScore(Handler.adultTeamResults);
        Streams.maxScore(Handler.teenAgerTeamResults);
        Streams.maxScore(Handler.pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Total teams score---------------------------------------");
//          Подсчет общего количества баллов:
        Streams.totalScore(Handler.adultTeamResults);
        Streams.totalScore(Handler.teenAgerTeamResults);
        Streams.totalScore(Handler.pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Teams without points------------------------------------");
//          Список команд без баллов:
        Streams.withoutPoints(Handler.adultTeamResults);
        Streams.withoutPoints(Handler.teenAgerTeamResults);
        Streams.withoutPoints(Handler.pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Average age in team ------------------------------------");
//          Средний возраст участников в каждой команде:
        Streams.getAverageAge(Handler.adultTeams);
        Streams.getAverageAge(Handler.teenAgerTeams);
        Streams.getAverageAge(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with above average scores ------------------------");
//          Команды с баллами выше среднего:
        Streams.getBestTeams(Handler.adultTeamResults);
        Streams.getBestTeams(Handler.teenAgerTeamResults);
        Streams.getBestTeams(Handler.pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Teams that beat a given team ---------------------------");
//        Команды с победами над определенной командой: Определить команды, которые выиграли у заданной команды.
        Streams.winnersTeams(Handler.fullAdultTeamResults, Generator.getRandomTeam(Handler.adultTeams));
        Streams.winnersTeams(Handler.fullTeenAgerTeamResults, Generator.getRandomTeam(Handler.teenAgerTeams));
        Streams.winnersTeams(Handler.fullPupilTeams, Generator.getRandomTeam(Handler.pupilTeams));

        System.out.println();
        System.out.println("-----------------The Youngest Participant in team------------------------");
//        Самый молодой участник среди всех команд:
        Streams.getYoungestParticipant(Handler.adultTeams);
        Streams.getYoungestParticipant(Handler.teenAgerTeams);
        Streams.getYoungestParticipant(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------The Oldest team-----------------------------------------");
//        Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.
        Streams.getExperiencedTeam(Handler.adultTeams);
        Streams.getExperiencedTeam(Handler.teenAgerTeams);
        Streams.getExperiencedTeam(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with participants in a age range------------------");
//        Команды с участниками в определенном возрастном диапазоне:
        Streams.getTeamInAgeRange(Handler.adultTeams, 44, 30);
        Streams.getTeamInAgeRange(Handler.teenAgerTeams, 29, 18);
        Streams.getTeamInAgeRange(Handler.pupilTeams, 17, 9);

        System.out.println();
        System.out.println("-----------------Names of participants in order of age from max to min---");
//        Имена участников по убыванию возраста:
        Streams.getParticipantsDescendingByAge(Handler.adultTeams);
        Streams.getParticipantsDescendingByAge(Handler.teenAgerTeams);
        Streams.getParticipantsDescendingByAge(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with the greatest age range-----------------------");
//        Найти команду с наибольшим разбросом возрастов участников.
        Streams.getTeamsWithMaxAgeRange(Handler.adultTeams);
        Streams.getTeamsWithMaxAgeRange(Handler.teenAgerTeams);
        Streams.getTeamsWithMaxAgeRange(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with the same total age---------------------------");
//        Найти все пары команд, чьи участники имеют одинаковый суммарный возраст.
        Streams.getTeamsWithSameTotalAge(Handler.adultTeams);
        Streams.getTeamsWithSameTotalAge(Handler.teenAgerTeams);
        Streams.getTeamsWithSameTotalAge(Handler.pupilTeams);


        System.out.println();
        System.out.println("-----------------Average Score in the team-------------------------------");
//        Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil).
        Streams.getAverageScore(Handler.adultTeams);
        Streams.getAverageScore(Handler.teenAgerTeams);
        Streams.getAverageScore(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams that scores improved with each game---------------");
//        Найти команды, чьи баллы улучшались с каждой игрой.
        Streams.getMostProgressiveTeam(Handler.adultTeams);
        Streams.getMostProgressiveTeam(Handler.teenAgerTeams);
        Streams.getMostProgressiveTeam(Handler.pupilTeams);
//
        System.out.println();
        System.out.println("-----------------Teams without losses------------------------------------");
//        Выявить команды, которые не имеют проигрышей.
        Streams.getTeamsWithoutLoses(Handler.adultTeams);
        Streams.getTeamsWithoutLoses(Handler.pupilTeams);
        Streams.getTeamsWithoutLoses(Handler.teenAgerTeams);

        System.out.println();
        System.out.println("-----------------Teams with draw-----------------------------------------");
//        Список команд, которые имели ничейные результаты с заданной командой.
        Streams.getTeamWithDraw(Handler.adultTeams, Generator.getRandomTeamName(Handler.adultTeams));
        Streams.getTeamWithDraw(Handler.teenAgerTeams, Generator.getRandomTeamName(Handler.teenAgerTeams));
        Streams.getTeamWithDraw(Handler.pupilTeams, Generator.getRandomTeamName(Handler.pupilTeams));

        System.out.println();
        System.out.println("-----------------All results between two team--------------------------------------");
//        Вывести результаты всех игр между двумя конкретными командами.
        Streams.getResultsBetweenSpecificTeams(Handler.adultTeams);
        Streams.getResultsBetweenSpecificTeams(Handler.teenAgerTeams);
        Streams.getResultsBetweenSpecificTeams(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Compare two teams--------------------------------------");
//        Сравнить две команды по средним баллам и среднему возрасту участников.
        Streams.checkTwoTeamsForPointsAndAge(Handler.adultTeams);
        Streams.checkTwoTeamsForPointsAndAge(Handler.teenAgerTeams);
        Streams.checkTwoTeamsForPointsAndAge(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with unique participants name---------------------");
//        Найти команды, в которых все участники имеют уникальные имена.
        Streams.getTeamWithUniqueParticipantsName(Handler.adultTeams);
        Streams.getTeamWithUniqueParticipantsName(Handler.teenAgerTeams);
        Streams.getTeamWithUniqueParticipantsName(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with the longest winning streak-------------------------------------");
//        Определить команды с самой длинной последовательностью побед.
        Streams.getMaxWinsTeam(Handler.adultTeams);
        Streams.getMaxWinsTeam(Handler.teenAgerTeams);
        Streams.getMaxWinsTeam(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------The most draws team-------------------------------------");
//        Найти команды с наибольшим количеством ничьих результатов.
        Streams.getMostDrawsTeam(Handler.adultTeams);
        Streams.getMostDrawsTeam(Handler.teenAgerTeams);
        Streams.getMostDrawsTeam(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with greatest improvement by the end of the season-");
// !!!       Выявить команды, которые показали наибольшее улучшение баллов к концу сезона.
//        Тоже самое что и с самой длинной последовательностью побед.
        Streams.getMaxWinsTeam(Handler.adultTeams);
        Streams.getMaxWinsTeam(Handler.teenAgerTeams);
        Streams.getMaxWinsTeam(Handler.pupilTeams);

        System.out.println();
        System.out.println("-----------------Total report--------------------------------------------");
//        Создать комплексный отчет, включающий средний возраст команды, общее количество баллов, наибольшую победную серию, и сравнение с другими командами.
        Streams.getReport(Handler.adultTeams);
        Streams.getReport(Handler.teenAgerTeams);
        Streams.getReport(Handler.pupilTeams);
    }

}

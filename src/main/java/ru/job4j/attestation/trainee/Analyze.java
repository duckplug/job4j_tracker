package ru.job4j.attestation.trainee;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(i -> i.getSubjects().stream()).mapToInt(Subject::getScore).average().orElse(0D);

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map()
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;


    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.hietala",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "AdventOfCode2015",
    libraryDependencies += scalaTest % Test
  )

lazy val day01 = taskKey[Unit]("Day 01")
fullRunTask(day01, Compile, "adventofcode2015.Day01")
lazy val day02 = taskKey[Unit]("Day 02")
fullRunTask(day02, Compile, "adventofcode2015.Day02")
lazy val day03 = taskKey[Unit]("Day 03")
fullRunTask(day03, Compile, "adventofcode2015.Day03")
lazy val day04 = taskKey[Unit]("Day 04")
fullRunTask(day04, Compile, "adventofcode2015.Day04")

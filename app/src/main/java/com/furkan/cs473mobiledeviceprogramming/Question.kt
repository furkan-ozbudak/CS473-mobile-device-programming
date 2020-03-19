package com.furkan.cs473mobiledeviceprogramming

class Question {
    var question: String
    var answerA: String
    var answerB: String
    var answerC: String
    var correctAnswer: String

    constructor(
        question: String, answerA: String,
        answerB: String, answerC: String, correctAnswer: String
    ) {
        this.question = question
        this.answerA = answerA
        this.answerB = answerB
        this.answerC = answerC
        this.correctAnswer = correctAnswer
    }

    override fun toString(): String {
        return this.question + " | " +
                this.answerA + " | " +
                this.answerB +
                " | " + this.answerC +
                " | " + this.correctAnswer;
    }
}
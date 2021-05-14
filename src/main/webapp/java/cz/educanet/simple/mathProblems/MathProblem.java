package cz.educanet.simple.mathProblems;

public class MathProblem {
	int solution;
	int wrongAnswer;
	String problem;

	public MathProblem() {

	}

	public MathProblem(int solution, int wrongAnswer, String problem) {
		this.solution = solution;
		this.wrongAnswer = wrongAnswer;
		this.problem = problem;
	}

	public MathProblem addition(int lowest1, int highest1, int lowest2, int highest2, int wrongAnswerRange) {
		int num1 = lowest1 + (int) (Math.random() * (highest1 - lowest1 + 1));
		int num2 = lowest1 + (int) (Math.random() * (highest2 - lowest2 + 1));
		int solution = num1 + num2;
		int wrongAnswer = Math.random() < 0.5 ? solution + (int) (Math.random() * (wrongAnswerRange)) : solution - (int) (Math.random() * (wrongAnswerRange));
		return new MathProblem(solution, wrongAnswer, num1 + " + " + num2  + " = ");
	}

	public MathProblem subtraction(int lowest1, int highest1, int lowest2, int highest2, int wrongAnswerRange) {
		int num1 = lowest1 + (int) (Math.random() * (highest1 - lowest1 + 1));
		int num2 = lowest1 + (int) (Math.random() * (highest2 - lowest2 + 1));
		int solution = num1 - num2;
		int wrongAnswer = Math.random() < 0.5 ? solution + (int) (Math.random() * (wrongAnswerRange)) : solution - (int) (Math.random() * (wrongAnswerRange));
		return new MathProblem(solution, wrongAnswer, num1 + " + " + num2  + " = ");
	}

	public MathProblem multiplication(int lowest1, int highest1, int lowest2, int highest2, int wrongAnswerRange) {
		int num1 = lowest1 + (int) (Math.random() * (highest1 - lowest1 + 1));
		int num2 = lowest1 + (int) (Math.random() * (highest2 - lowest2 + 1));
		int solution = num1 * num2;
		if(Math.random() < 0.5){
			wrongAnswer = Math.random() < 0.5 ? solution - num1: solution + num1;
		}else{
			wrongAnswer = Math.random() < 0.5 ? solution - num2: solution + num2;
		}
		wrongAnswer += Math.random() < 0.5 ? -wrongAnswerRange : +wrongAnswerRange;
		int wrongAnswer = Math.random() < 0.5 ? solution + (int) (Math.random() * (wrongAnswerRange)) : solution - (int) (Math.random() * (wrongAnswerRange));
		return new MathProblem(solution, wrongAnswer, num1 + " * " + num2 + " = ");
	}

	public MathProblem division(int lowestSolution, int highestSolution, int lowestDivisor, int highestDivisor, int wrongAnswerRange) {
		int solution = lowestSolution + (int) (Math.random() * (highestSolution - lowestSolution + 1));
		int divisor = lowestDivisor + (int) (Math.random() * (highestDivisor - lowestDivisor + 1));
		int dividend = divisor * solution;
		wrongAnswer = Math.random() < 0.5 ? solution - wrongAnswerRange: solution + wrongAnswerRange;
		return new MathProblem(solution, wrongAnswer, dividend + " : " + divisor + " = ");
	}

}

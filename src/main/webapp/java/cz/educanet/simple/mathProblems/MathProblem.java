package cz.educanet.simple.mathProblems;

public class MathProblem {
	int solution;
	int wrongAnswer;
	String problem;

	public MathProblem(){

	}

	public MathProblem(int solution, int wrongAnswer, String problem){
		this.solution = solution;
		this.wrongAnswer = wrongAnswer;
		this.problem = problem;
	}

	public MathProblem addition(int lowest1, int highest1,int lowest2,int highest2, int wrongAnswerRange){
		int num1 = lowest1 + (int)(Math.random() * (highest1-lowest1+1));
		int num2 = lowest1 + (int)(Math.random() * (highest2-lowest2+1));
		int solution = num1 + num2;
		int wrongAnswer = Math.random() < 0.5? solution + (int)(Math.random() * (wrongAnswerRange)):solution - (int)(Math.random() * (wrongAnswerRange));
		return new MathProblem(solution,wrongAnswer,num1 + " + " + num2);
	}
}

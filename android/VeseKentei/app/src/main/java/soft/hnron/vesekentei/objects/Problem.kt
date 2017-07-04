package soft.hnron.vesekentei.objects

object Problem {

    private var problems: List<Array<String>>? = null

    private var problemsIterator: Iterator<Array<String>>? = null

    var problem: Array<String>? = null
        get() = field
        private set

    var statement: String? = null
        get() = problem?.get(0)
        private set

    var correctNumber: Int? = null
        get() = problem?.get(1)?.toInt()
        private set

    var selectorZero: String? = null
        get() = problem?.get(2)
        private set

    var selectorOne: String? = null
        get() = problem?.get(3)
        private set

    var selectorTwo: String? = null
        get() = problem?.get(4)
        private set

    var selectorThree: String? = null
        get() = problem?.get(5)
        private set

    var correctText: String? = null
        get() = problem?.get(6)
        private set

    var description: String? = null
        get() = problem?.get(7)
        private set

    var problemNumber: Int? = null
        get() = field
        private set


    fun initialization(problems: List<Array<String>>) {
        this.problems = problems
        this.problemsIterator = problems.iterator()
        next()
        problemNumber = 1
    }

    fun next(): Array<String>? {
        if (problemsIterator?.hasNext()!!) {
            problem = problemsIterator?.next()
            problemNumber?.plus(1)
            return problem
        } else {
            return null
        }
    }
}

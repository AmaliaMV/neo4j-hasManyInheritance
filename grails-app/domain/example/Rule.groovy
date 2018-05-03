package example

class Rule {

    static mapWith = "neo4j"

    static hasMany = [actions: Action]

    List<Action> actions

    String name

    static constraints = {
    }
}

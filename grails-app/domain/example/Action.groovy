package example

class Action {

    static mapWith = "neo4j"

    static belongsTo = [rule: Rule]

    String description

    static constraints = {
    }
}

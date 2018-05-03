package example

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback

import spock.lang.Specification

@Integration
@Rollback
class RuleIntegrationSpec extends Specification {

    def "check action's class after a rule is saved"() {

        given: "a rule with a SpecialAction action"

        Rule rule = new Rule(name: 'bus_rul_1')
        SpecialAction specialAction = new SpecialAction(description: 'special action')
        rule.addToActions(specialAction)
        rule.save(failOnError: true, flush:true)

        when: "get the action from the database"

        Action action = Action.findByDescription('special action')

        then: "the action's class is correct"

        action.class == SpecialAction
    }

}

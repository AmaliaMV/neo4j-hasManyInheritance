package neo4j.hasmanyinheritance

import example.Action
import example.Rule
import example.SpecialAction
import example.SuperSpecialAction

class BootStrap {

    def init = { servletContext ->

        Rule.withNewSession {
            Rule.withNewTransaction {
                String name = 'rule1'
                Rule rule = Rule.findByName(name)
                if (rule) {
                    rule.delete()
                }

                new Rule(name: name)
                    .addToActions(new SpecialAction(description: 'special action 1'))
                    .addToActions(new SuperSpecialAction(description: 'super special action 1'))
                    .save(flush: true)


         /*       Action action1 = Action.findByDescription('special action 1')
                assert action1.class == SpecialAction

                Action action2 = Action.findByDescription('super special action 1')
                assert action2.class == SuperSpecialAction*/
            }
        }

    }
    def destroy = {
    }
}

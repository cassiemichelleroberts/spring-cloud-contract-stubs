import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("beer approval")
    description('''
        given:
        	A request for a beer is received
        when:
        	the age is 21 or above
        then:
        	the beer is approved
    ''')
    request {
        method 'PUT'
        url '/check'
        body(
                age: value(consumer(regex('[2-9][0-9]')))
        )
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body(
                beerCheckStatus: "OKAY"
        )
        headers {
            contentType('application/json')
        }
    }
}

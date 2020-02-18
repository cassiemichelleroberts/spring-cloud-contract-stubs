import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('''
        given:
        	An inout is received
        when:
        	something
        then:
        	Output
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

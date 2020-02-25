import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("beer denial")
    description('''
        given:
        	A request for a beer is received
        when:
        	the age is 20 or below
        then:
        	the beer is denied
    ''')
    request {
        method 'PUT'
        url '/check'
        body([
                "age": 19
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body([
                beerCheckStatus: "UNDERAGE"
        ])
        headers {
            contentType('application/json')
        }
    }
}


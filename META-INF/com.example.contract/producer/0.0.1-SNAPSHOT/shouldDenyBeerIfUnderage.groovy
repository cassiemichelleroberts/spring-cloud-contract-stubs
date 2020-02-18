import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/check'
        body([
                "age": 18
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


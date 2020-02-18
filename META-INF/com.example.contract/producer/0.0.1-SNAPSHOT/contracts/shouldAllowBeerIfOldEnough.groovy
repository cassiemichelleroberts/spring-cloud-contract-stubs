import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/check'
        body([
                "age": 21
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body([
                beerCheckStatus: "OKAY"
        ])
        headers {
            contentType('application/json')
        }
    }
}

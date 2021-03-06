class HystrixCircuitBreakerGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.0 > *"
    def pluginExcludes = [
        "grails-app/controllers/hystrix/circuit/breaker/TestController.groovy"
    ]
    def title = "Hystrix Circuit Breaker Plugin"
    def description = 'Hystrix is awesome, this is an attempt to make it easy to use for a Grails application'
    def documentation = "http://grails.org/plugin/hystrix-circuit-breaker"

    def license = "APACHE"
    def developers = [
        [name: 'Demian Neidetcher', email: 'demian0311@gmail.com']
    ]
    def issueManagement = [system: 'GITHUB', url: 'https://github.com/demian0311/hystrix-circuit-breaker/issues']
    def scm = [url: 'https://github.com/demian0311/hystrix-circuit-breaker']

    def doWithWebDescriptor = { xml ->
        def mappingElement = xml.'servlet-mapping'

        def lastMapping = mappingElement[mappingElement.size() - 1]
        lastMapping + {
            'servlet' {
                'servlet-name'("HystrixMetricsStreamServlet")
                'display-name'("HystrixMetricsStreamServlet")
                'servlet-class'("com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet")
                'description'("")
            }
            'servlet-mapping' {
                'servlet-name'("HystrixMetricsStreamServlet")
                'url-pattern'("/hystrix.stream")
            }
        }
    }
}

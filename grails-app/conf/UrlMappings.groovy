class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/"(controller: "/index/index")
        "/application"(controller: "/application/index")
		"500"(view:'/error')
	}
}

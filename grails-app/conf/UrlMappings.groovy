class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/"(controller: "/index/index")
        "/application"(controller: "/application/index")
        "/access"(controller: "/access/index")
        "/logdetails/$collectionName/$id"(controller: "logDetails")
		"500"(view:'/error')
	}
}

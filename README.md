### Features

The given application allows the following operations:
- Exchange peruavian soles to american dollars
- Exchange american dollars to peruvian soles

But in order to get access, you must get an authorization token to execute the request.

![](https://img.shields.io/badge/POST-%2Fauthentication-blue)
**About the exposed functionality**
Allows to generate a token to get access to exchange functionalities. It recieves a user and password as atributes in order to generate the token.

**Atributes**

|  Atributes |  Values |
| ------------ | ------------ |
| user  | *given user * |
| password  | *given password*  |

![](https://img.shields.io/badge/GET-%2Fexchange-red)
**About the exposed functionality**
Allows currency exchange between 2 currencies

**List of used values**
 Fields that have more than one possible value are listed below.

|  Atributes |  Values |
| ------------ | ------------ |
| to  | PEN, USD  |
| from  | PEN, USD  |
| amount  | >=1 |

**Parameters**

|  Name |  Description |
| ------------ | ------------ |
| Authorization ***required ** | Bearer eyJhbGciOiJIUzUxMiJ9  |

**Request Body *requiered** (json)

    {
		"to": "PEN",
		"from": "USD",
		"amount": 5.0
	}
    
**Response** (json)

    {
		"date": "2023/05/19 17:46:37",
		"query": {
			"to": "PEN",
			"from": "USD",
			"amount": 5.0
		},
		"result": 18.48
	}
    

### Postman Collection
A collection has been added to the root of this project.
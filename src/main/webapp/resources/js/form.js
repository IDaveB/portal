$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
//        feedbackIcons: {
//            valid: 'glyphicon glyphicon-ok',
//          invalid: 'glyphicon glyphicon-remove',
//           validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
            nombre: {
                message: 'El nombre no es valido',
                validators: {
                    notEmpty: {
                        message: 'Nombre requerido'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z]+$/,
                        message: 'Este campo solo puede contener letras'
                    }
                }
            },
            apellidos: {
                message: 'Los apelldos no son validos',
                validators: {
                    notEmpty: {
                        message: 'Apellidos requerido'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z]+$/,
                        message: 'Este campo solo puede contener letras'
                    }
                }
            },
            country: {
                validators: {
                    notEmpty: {
                        message: 'The country is required and can\'t be empty'
                    }
                }
            },
            acceptTerms: {
                validators: {
                    notEmpty: {
                        message: 'You have to accept the terms and policies'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Email requerido'
                    },
                    emailAddress: {
                        message: 'Introduzca un email correcto'
                    }
                }
            },
            website: {
                validators: {
                    uri: {
                        allowLocal: true,
                        message: 'The input is not a valid URL'
                    }
                }
            },
            telefono: {
                validators: {
                	notEmpty: {
                        message: 'Telefono requerido'
                    },
                    digits: {
                        message: 'Introduzca un telefono correcto'
                    }
                }
            },
            phoneNumberUK: {
            	validators: {
            		notEmpty: {
                        message: 'El campo telefono no puede estar vacio'
                    },
            		phone: {
            			message: 'Introduzca un telefono correcto',
            			country: 'GB'
            		}
            	}
            },
            color: {
                validators: {
                    hexColor: {
                        message: 'The input is not a valid hex color'
                    }
                }
            },
            zipCode: {
                validators: {
                    zipCode: {
                        country: 'US',
                        message: 'The input is not a valid US zip code'
                    }
                }
            },
            pass: {
                validators: {
                    notEmpty: {
                        message: 'Contraseña requerida'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: 'Las contraseñas deben ser iguales'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'Contraseña requerida'
                    },
                    identical: {
                        field: 'pass',
                        message: 'Las contraseñas deben ser iguales'
                    }
                }
            },
            ages: {
                validators: {
                    lessThan: {
                        value: 100,
                        inclusive: true,
                        message: 'The ages has to be less than 100'
                    },
                    greaterThan: {
                        value: 10,
                        inclusive: false,
                        message: 'The ages has to be greater than or equals to 10'
                    }
                }
            }
        }
    });
});
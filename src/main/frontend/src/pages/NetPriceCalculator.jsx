import { useState, useEffect } from "react";
import './netpricecalculator.css'

import apis from '../api/client'

const NetPriceCalculator = () => {
    const [countries, setCountries] = useState([]);
    const [selectedCountry, setSelectedCountry] = useState();
    const [gross, setGross] = useState(1);
    const [price, setPrice] = useState();

    useEffect(() => {
        apis.getCountries()
            .then(response => {
                setCountries(response.data.country_list);
            })
    }, []);

    useEffect(() => {
        if (!!selectedCountry) {
            function init() {
                handleGrossChange();
            }
            init();
        }
    }, [selectedCountry, gross]);

    function handleGrossChange() {
        if (gross) {
            apis.calculateNetPrice(gross, selectedCountry).then(
                response => setPrice(response.data.net_price)
            );
        }
    }

    return (
        <div className="price-calculator">
            <h1>Price Calculator</h1>
            <div className="group">
                <div className="form-input-group">
                    <div className="input-label">
                        <label>
                            {"Select Country:"}
                        </label>
                    </div>
                    <div className="select-input">
                        <select className='no-scroll' value={selectedCountry} onChange={ev => setSelectedCountry(ev.target.value)}>
                            {countries.map((country => (
                                <option value={country.code}>{country.name}</option>
                            )))}
                        </select>
                    </div>

                </div>

                <div className="form-input-group">
                    <div className="input-label">
                        <label>
                            {"Gross:"}
                        </label>
                    </div>
                    <input type="text" value={gross} onChange={ev => setGross(ev.target.value)} />

                </div>

                
                <div className="form-input-group">
                    <div className="input-label">
                        <label>
                            {"Net Price:"}
                        </label>
                    </div>
                    <input type="text" value={price} readOnly />

                </div>
            </div>
        </div>
    );

}

export default NetPriceCalculator;
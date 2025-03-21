import React, { useState } from 'react'
import './Home.css'
import { Link } from 'react-router-dom'
import { BsFilter, BsSearch, BsHouseDoor, BsPlusCircle, BsCash, BsChatDots, BsPerson } from 'react-icons/bs'

const Home = () => {

    return (
        <div className="layout">
            {/* Left Column */}
            <div className="left-column">
                <div className="logo">
                    <h1>Seedling</h1>
                </div>
                <div className="top-section">
                    <nav className="nav-links">
                        <Link to="/"><BsHouseDoor className="nav-icon" /> Home</Link>
                        <Link to="/"><BsPlusCircle className="nav-icon" /> Add</Link>
                        <Link to="/"><BsCash className="nav-icon" /> Funding</Link>
                        <Link to="/"><BsChatDots className="nav-icon" /> Chat</Link>
                        <Link to="/"><BsPerson className="nav-icon" /> Profile</Link>
                    </nav>
                </div>
            </div>

            {/* Middle Column */}
            <div className="middle-column">
                <div className="header">
                    <div className="search-bar">
                        <BsSearch className="search-icon" />
                        <input type="text" placeholder="Search" />
                    </div>
                </div>
                <div className="content-container">
                    <div className="content">
                        <div className="content-header">
                            <div className="profile-section">
                                <div className="profile-pic">
                                    {/* <img src="" alt="" /> */}
                                </div>
                                <div className="user-info">
                                    <span className="user-name">Adarsh C.</span>
                                    <span className="user-title">DevRel Engineer | Sharing the latest ...</span>
                                </div>
                            </div>
                        </div>

                        <div className="content-main"></div>

                        {/* Comment Box Section */}
                        <div className="content-footer">
                            <img className='comment-icon' src="./images/comment.svg" alt="" />
                            <input className='comment-input' type="text" placeholder='Enter your comment'/>
                        </div>
                    </div>
                </div>
            </div>

            {/* Right Column */}
            <div className="right-column">
                <div className="top-section">
                    <div className='right-search'>
                        <input type="text" placeholder="Search filters..." />
                    </div>
                    <div className="right-filters">
                        <div className="filter-header">
                            <h3>Filters</h3>
                            <BsFilter className="filter-icon" />
                        </div>
                        <div className="filter-options">
                            {/* Filter options will go here */}
                        </div>
                    </div>
                </div>
                <div className="bottom-section rounded">
                    <Link to="/">Seedling Pro</Link>
                </div>
            </div>
        </div>
    )
}

export default Home;
